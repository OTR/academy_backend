package com.github.otr.academy_backend.infrastructure.repository

import com.github.otr.academy_backend.domain.model.Category
import com.github.otr.academy_backend.domain.repository.CategoryRepository


import org.springframework.stereotype.Repository

/**
 *
 */
@Repository
class MockCategoryRepositoryImpl: CategoryRepository {

    override fun getAll(): List<Category> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): Category {
        TODO("Not yet implemented")
    }

    override fun create(entity: Category): Category {
        TODO("Not yet implemented")
    }

    override fun update(entity: Category): Category {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }
}
//    val banks = mutableListOf(
//        Bank("1234",3.14,17),
//        Bank("1010",17.0,0),
//        Bank("5678",0.0,100),
//    )
//
//    override fun retrieveBanks(): Collection<Bank> = banks
//
//    override fun retrieveBank(accountNumber: String): Bank {
//        return banks.firstOrNull() { it.accountNumber == accountNumber }
//            ?: throw NoSuchElementException("Could not find a bank with account numbrer $accountNumber")
//    }
//
//    override fun createBank(bank: Bank): Bank {
//        if (banks.any {it.accountNumber == bank.accountNumber}) {
//            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists")
//        }
//        banks.add(bank)
//
//        return bank
//    }
//
//    override fun updateBank(bank: Bank): Bank {
//        val currentBank: Bank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
//            ?: throw NoSuchElementException("Could not find a bank with account numbrer ${bank.accountNumber}")
//
//        banks.remove(currentBank)
//        banks.add(bank)
//
//        return bank
//    }
//
//    override fun deleteBank(accountNumber: String) {
//        val currentBank: Bank = banks.firstOrNull { it.accountNumber == accountNumber }
//            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")
//
//        banks.remove(currentBank)
//    }
//}
